package siga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOBanco implements AlunoDAO {
    private final String url;
    private final String usuario;
    private final String senha;

    public AlunoDAOBanco(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(this.url, this.usuario, this.senha);
    }

    @Override
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (matricula, nome, media) VALUES (?, ?, ?)";

        try (Connection conexao = conectar();
        PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, aluno.getMatricula());
            comando.setString(2, aluno.getNome());
            comando.setDouble(3, aluno.getMedia());
            comando.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir aluno", e);
        }
    }

    @Override
    public Aluno buscarPorMatricula(String matricula) {
        String sql = "SELECT nome, matricula, media FROM aluno WHERE matricula = ?";

        try (Connection conexao = conectar();
        PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, matricula);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()){
                String nome = resultado.getString("nome");
                String matriculaDoBanco = resultado.getString("matricula");
                double media = resultado.getDouble("media");
                return new Aluno(nome, matriculaDoBanco, media);
            }
            }catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar aluno", e);
            }
        return null;
    }

    @Override
    public List<Aluno> listarTodos() {
        String sql = "SELECT nome, matricula, media FROM aluno";
        List<Aluno> alunos = new ArrayList<>();
        try (Connection conexao = conectar();
        PreparedStatement comando = conexao.prepareStatement(sql)) {
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String matricula = resultado.getString("matricula");
                double media = resultado.getDouble("media");
                alunos.add(new Aluno(nome, matricula, media));
            }
        }catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos", e);
        }
        return alunos;
    }

    @Override
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, media = ? WHERE matricula = ?";
        try (Connection conexao = conectar();
        PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, aluno.getNome());
            comando.setDouble(2, aluno.getMedia());
            comando.setString(3, aluno.getMatricula());
            comando.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno", e);
        }
    }

    @Override
    public void remover(String matricula) {
        String sql = "DELETE FROM aluno WHERE matricula = ?";
        try (Connection conexao = conectar();
        PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, matricula);
            comando.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover aluno", e);
        }
    }

}
