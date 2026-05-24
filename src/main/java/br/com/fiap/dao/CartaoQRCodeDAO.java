package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.CartaoQRCode;
import br.com.fiap.entities.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartaoQRCodeDAO {

    public Connection minhaConexao;

    // metodo construtor com parâmetro vazio
    public CartaoQRCodeDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(CartaoQRCode cartaoQRCode) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into CARTAOQRCODE(ID_CARTAO, CODIGO_HASH, DATA_EMISSAO, STATUS, ID_PACIENTE) values (?, ?, ?, ?, ?)");
        stmt.setInt(1, cartaoQRCode.getIdcartao());
        stmt.setString(2, cartaoQRCode.getCodigo());
        stmt.setString(3, cartaoQRCode.getDataemissao());
        stmt.setString(4,  cartaoQRCode.getStatus());
        stmt.setInt(5, cartaoQRCode.getIdpaciente());

        stmt.execute();
        stmt.close();

        return "CartaoQrCode cadastrado com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from CARTAOQRCODE where = id_cartaoqrcode ");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return  "CartaoQRCode deletado com sucesso!";
    }

    // UpDate
    public String atualizar(CartaoQRCode cartaoQRCode) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update CARTAOQRCODE set ID_CARTAO = ?, CODIGO_HASH = ?, DATA_EMISSAO= ?, STATUS= ?, ID_PACIENTE= ?, where id_cartao = ?");
        stmt.setInt(1, cartaoQRCode.getIdcartao());
        stmt.setString(2, cartaoQRCode.getCodigo());
        stmt.setString(3, cartaoQRCode.getDataemissao());
        stmt.setString(4, cartaoQRCode.getStatus());
        stmt.setInt(5, cartaoQRCode.getIdpaciente());

        stmt.executeUpdate();
        stmt.close();

        return "CartaoQRCode atualizado com sucesso!";
    }

    // Select
    public List<CartaoQRCode> selecionar() throws SQLException {
        List<CartaoQRCode> listaCartoes = new ArrayList<CartaoQRCode>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from CARTAOQRCODE");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            CartaoQRCode cartaoQRCode = new CartaoQRCode();
            cartaoQRCode.setIdcartao(rs.getInt(1));
            cartaoQRCode.setCodigo(rs.getString(2));
            cartaoQRCode.setDataemissao(rs.getString(3));
            cartaoQRCode.setStatus(rs.getString(4));
            cartaoQRCode.setIdpaciente(rs.getInt(5));
            listaCartoes.add(cartaoQRCode);
        }
        return listaCartoes;
    }

    // Buscar por ID
    public CartaoQRCode buscarPorID(int id) throws SQLException {
        CartaoQRCode cartaoQRCode = null;

        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM CARTAOQRCODE WHERE ID_CARTAO = ?"
        );
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            cartaoQRCode = new CartaoQRCode();
            cartaoQRCode.setIdcartao(rs.getInt(1));
            cartaoQRCode.setCodigo(rs.getString(2));
            cartaoQRCode.setDataemissao(rs.getString(3));
            cartaoQRCode.setStatus(rs.getString(4));
            cartaoQRCode.setIdpaciente(rs.getInt(5));
        }

        rs.close();
        stmt.close();

        return cartaoQRCode;
    }

}

