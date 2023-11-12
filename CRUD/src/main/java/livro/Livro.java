/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livro;


import entity.Entity;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author Caio Veloso &lt;caio.veloso at ifnmg.edu.br&gt;
 */

public class Livro extends Entity{
    
    private String autor;
    private String titulo;
    private LocalDate aquisicao;
    private BigDecimal preco;
    
    public Livro() {
    }

public Livro(Long id,String titulo, String autor, LocalDate aquisicao, BigDecimal preco) throws Exception{
        
        setId(id);
        setTitulo(titulo);
        setAutor(autor);
        setAquisicao(aquisicao); 
        setPreco(preco);
        
    }

    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws Exception {
        if(titulo.length()>150){
            throw new Exception("Tamanho não permitido");
        }
                this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) throws Exception {
        if(autor.length()>250){
            throw new Exception("Tamanho não permitido");
        }
        this.autor = autor;
    }

    public LocalDate getAquisicao() {
        return aquisicao;
    }

    public void setAquisicao(LocalDate aquisicao) throws Exception {
        if(aquisicao.isBefore(LocalDate.now())) this.aquisicao = aquisicao;
        else throw new DateTimeException("Data não permitida");
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) throws Exception {
        if(preco.compareTo(BigDecimal.ZERO)<0){
            throw new Exception ("Preço inválido");
    }
        this.preco = preco;
    }
    
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Livro{" + "autor=" + autor + ", titulo=" + titulo + ", aquisicao=" + aquisicao + ", preco=" + preco + '}';
    }

   

    
}

