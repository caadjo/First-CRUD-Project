/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livro;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.Dao;


/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */

public class LivroDao extends Dao<Livro> {
    
    public static final String TABLE = "livro";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(titulo, autor, aquisição, preço) values(?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return " update "+ TABLE + " set titulo = ?, autor = ?, aquisição = ?, preço = ? where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, titulo, autor, aquisição, preço" + " from livro where id = ?"; 
    }

    @Override
    public String getFindAllStatment() {
        return "select id, titulo, autor, aquisição, preço" + " from livro";
    }

    @Override
    public String getDeleteStatment() {
         return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Livro e) {
    try {
        pstmt.setString(1, e.getTitulo());
        pstmt.setString(2, e.getAutor());
        pstmt.setObject(3, e.getAquisicao());
        pstmt.setBigDecimal(4, e.getPreco());

   
        if (e.getId() != null) {
            pstmt.setLong(5, e.getId());
        }
      }  catch (SQLException ex){
        Logger.getLogger(LivroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public Livro extractObject(ResultSet resultSet) {
    

        Livro livro = null;

        try {
            livro = new Livro();
            livro.setId(resultSet.getLong("id"));
            livro.setTitulo(resultSet.getString("titulo"));
            livro.setAutor(resultSet.getString("autor"));
            livro.setAquisicao( resultSet.getObject("aquisição", LocalDate.class));
            livro.setPreco(resultSet.getBigDecimal("preço"));
        }catch (Exception ex) {
            Logger.getLogger(LivroDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return livro;
    }


    @Override
public List<Livro> extractObjects(ResultSet resultSet) {
    List<Livro> livroList = new ArrayList<>();

    try {
        while (resultSet.next()) {
            Livro livro = new Livro();
            livro.setId(resultSet.getLong("id"));
            livro.setTitulo(resultSet.getString("titulo"));
            livro.setAutor(resultSet.getString("autor"));
            livro.setAquisicao(resultSet.getObject("aquisição", LocalDate.class));
            livro.setPreco(resultSet.getBigDecimal("preço"));
            livroList.add(livro);
        }
    } catch (Exception ex) {
            Logger.getLogger(LivroDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return livroList;
}
  
}
