/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.edu.ifnmg.crud;

import livro.Livro;
import livro.LivroDao;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class CRUD {

    public static void main(String[] args) throws Exception {
      
            try {
// LIVRO ,AUTOR , data e preco
           //<editor-fold defaultstate="collapsed" desc="CRIA OS LIVROS">
                // Criar e salvar o primeiro livro com data posterior a data de hoje
                Livro livro0 = new Livro(null, "O CONTINENTE", "Érico Veríssimo", LocalDate.of(2023, 12, 31), new BigDecimal("30.50"));
                Long livro0ID = new LivroDao().saveOrUpdate(livro0);
                livro0.setId(livro0ID);
            } catch (Exception e) {
                System.out.println(">> " + e.getMessage());
            }

            // Criar e salvar o primeiro livro
            Livro livro1 = new Livro(null, "HARRY POTTER", "AUTOR 2", LocalDate.of(2023, 4, 8), new BigDecimal("31.00"));;
            Long livro1ID = new LivroDao().saveOrUpdate(livro1);
            livro1.setId(livro1ID);

            // Criar e salvar o segundo livro
            Livro livro2 = new Livro(null, "CRONICAS DE NARNIA", "AUTOR 3", LocalDate.of(2023, 4, 8), new BigDecimal("32.00"));
            Long livro2ID = new LivroDao().saveOrUpdate(livro2);
            livro2.setId(livro2ID);

            // Criar e salvar o terceiro livro
            Livro livro3 = new Livro(null, "PETER PAN", "AUTOR 4", LocalDate.of(2023,4, 8), new BigDecimal("15.70"));
            Long livro3ID = new LivroDao().saveOrUpdate(livro3);
            livro3.setId(livro3ID);

            //</editor-fold
            
           //<editor-fold defaultstate="collapsed" desc="UPDATE LIVRO 1">
           
            Livro livro1Aux = new LivroDao().findById(livro1ID);
            
            System.out.println("\nBusca Antigo: " + livro1Aux);

            livro1Aux.setTitulo("TITULO ATUALIZADO");
            new LivroDao().saveOrUpdate(livro1Aux);
            System.out.println(">> Livro 1 foi atuliazado\n");
            
            //</editor-fold>
            
           //<editor-fold defaultstate="collapsed" desc="BUSCA 2 LIVROS POR ID">
            
           System.out.println("2 LIVROS BUSCADOS: \n");
           
            LivroDao BuscaId = new LivroDao();
            System.out.println(">> "+BuscaId.findById(livro3ID) );
            
            LivroDao BuscaId2 = new LivroDao();
            System.out.println(">> "+BuscaId2.findById(livro2ID) );
            
            //</editor-fold>
           
           //<editor-fold defaultstate="collapsed" desc="MOSTRA TODOS">
 
           System.out.println("\n>> TODOS OS LIVROS DO BD");
             try {
            LivroDao BuscaTodos = new LivroDao();
            for(Livro e: BuscaTodos.findAll()){
                System.out.println(">> "+ e);
                
             //</editor-fold>
            
           //<editor-fold defaultstate="collapsed" desc="DELETE LIVRO 2">
            
             LivroDao deleteLivro = new LivroDao();
             deleteLivro.delete(livro2ID);
             
           //</editor-fold>
 
             
             
            }       
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}



            

            
            
