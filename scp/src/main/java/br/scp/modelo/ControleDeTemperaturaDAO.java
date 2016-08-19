package br.scp.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.scp.servico.FabricaDeConexoes;

public class ControleDeTemperaturaDAO {
	Logger logger = Logger.getLogger(ControleDeTemperaturaDAO.class);
	public int adiciona(String cnpj,ControleDeTemperatura controleDeTemperatura){
		PreparedStatement ps;
		int codigoRetorno=0;
		try (Connection conn = new FabricaDeConexoes().getConnection()){
			ps = (PreparedStatement) conn.prepareStatement(
					"insert into controledetemperatura (empresa_cnpj, temperaturaMaxima, horarioInicio, horarioTermino) values (?,?,?,?)");
			ps.setString(1,cnpj);
			ps.setInt(2,controleDeTemperatura.getTemperaturaMaxima());
			ps.setInt(3, controleDeTemperatura.getHorarioInicio());
			ps.setInt(4, controleDeTemperatura.getHorarioTermino());
			
			codigoRetorno = ps.executeUpdate();
			logger.info("codigo de retorno do metodo adiciona controle de temperatura = " + codigoRetorno);

			ps.close();
			
		} catch (SQLException e){
				throw new RuntimeException(e);
			}
		return codigoRetorno;
	}
	
	public int exclui (String cnpj) {
		java.sql.PreparedStatement ps;
		int codigoretorno = 0;
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps= conn.prepareStatement ("delete from empresa where cnpj = ?");
			ps.setString(1, cnpj);
			codigoretorno = ps.executeUpdate();
			}
		catch (SQLException e){
			throw new RuntimeException(e);
		}
	return codigoretorno;
	
	}
	
	public static Empresa consultaEmpresa(String cnpj) {
		Empresa empresa = null;
		java.sql.PreparedStatement ps;
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = conn.prepareStatement("select * from empresa where cnpj = ?");
			ps.setString(1, cnpj);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				empresa = new Empresa();
				empresa.setCnpj(resultSet.getString("cnpj"));
				empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
				empresa.setEndereco(resultSet.getString("endereco"));
				empresa.setTelefone(resultSet.getString("telefone"));
				empresa.setHorarioEntrada(resultSet.getInt("horarioEntrada"));
				empresa.setHorarioSaida(resultSet.getInt("horarioSaida"));
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return empresa;
	}
}
