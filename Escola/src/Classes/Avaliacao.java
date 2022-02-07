package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Util.Conexao;

public class Avaliacao {

	int codDisciplina;
	int codAluno;
	int nrAvaliacao;
	Double vlrAvaliacao;

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public int getNrAvaliacao() {
		return nrAvaliacao;
	}

	public void setNrAvaliacao(int nrAvaliacao) {
		this.nrAvaliacao = nrAvaliacao;
	}

	public Double getVlrNota() {
		return vlrAvaliacao;
	}

	public void setVlrNota(Double vlrNota) {
		this.vlrAvaliacao = vlrAvaliacao;

	}

	public boolean incluirAvaliacao() {

		Connection con = Conexao.conectar();
		String sql = "insert into avaliacao(codAluno, codDisciplina,"
				+ " nrAvaliacao, vlrNota) values(?,?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, this.codAluno);
			stm.setInt(2, this.codDisciplina);
			stm.setInt(3, this.nrAvaliacao);
			stm.setDouble(4, this.vlrAvaliacao);

			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public void alterarAvaliacao() {

	    Connection  connection = Conexao.conectar();
	    PreparedStatement  pstm =null;
	    
	    try {
	        String sql = "UPDATE avaliacao SET "
	                + "codaluno =?, "
	                + "codDisciplina=?, "
	                + "nrAvaliacao=?, "                    
	                + "vlrAvaliacao=?, "
	             
	                + "WHERE codaluno =?";
	        pstm = connection.prepareStatement(sql);
	        
	        pstm.setInt(1, this.codAluno);
	        pstm.setInt(2, this.codDisciplina);
	        pstm.setInt(3, this.nrAvaliacao);
	        pstm.setDouble(4, this.vlrAvaliacao);           
	                     
	        pstm.setInt(5, this.codAluno);
	        
	        pstm.execute();
	        JOptionPane.showMessageDialog(null, "Alterado com Sucesso",
	                "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);            
	    } catch (SQLException erro) {
	        
	        JOptionPane.showMessageDialog(null,"Erro ao alterar dados de conta"
	                + " no banco","Erro",
	                JOptionPane.ERROR_MESSAGE);   	        
	    }       	   
	}

	 public void excluirAvaliacao() {

	        Connection  connection = Conexao.conectar();
	        PreparedStatement  pstm =null;
	        
	        try {
	            String sql = "DELETE FROM avaliacao WHERE codAluno=?";
	            pstm = connection.prepareStatement(sql);
	            
	            pstm.setInt(1, this.codAluno);
	            pstm.execute();
	            JOptionPane.showMessageDialog(null, "Removido com Sucesso",
	                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);
	            
	        } catch (SQLException erro) {            
	            JOptionPane.showMessageDialog(null,"Erro ao Deleta conta no banco",
	                    "Erro",JOptionPane.ERROR_MESSAGE); 
	        }    	
	    	
	    	
	    }

	    /**
	     * 
	     */

	
	 public List<Avaliacao> consultarAvaliacoes(Integer codAluno) {
	      
	    	
    	 List<Avaliacao> avaliacao = new ArrayList<>();
         Connection  connection = Conexao.conectar();
         PreparedStatement  pstm =null;
         ResultSet resultSet = null;
         
         try {
             String sql = "SELECT *FROM despesa WHERE codaluno=?;";
             pstm = connection.prepareStatement(sql);
             pstm.setInt(1, this.codAluno);
             resultSet = pstm.executeQuery();
             
             while (resultSet.next()) { 
                 
               Avaliacao objAvaliacao = new Avaliacao();
                 objAvaliacao.setCodAluno(resultSet.getInt("codAluno"));
                 objAvaliacao.setCodDisciplina(resultSet.getInt("codDisciplina"));
                 objAvaliacao.setNrAvaliacao(resultSet.getInt("NrAvaliacao"));                                
                 objAvaliacao.setVlrNota(resultSet.getDouble("vlrAvaliacao"));
                               
                 avaliacao.add(objAvaliacao);         
             }
         } catch (SQLException erro) {            
             JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco",
                     "Erro",JOptionPane.ERROR_MESSAGE); 
         }  
        
         
         return avaliacao;
    	
    	
    }

    /**
     * 
     */
	 
	 
	 public List<Avaliacao>listarAvaliacoes() {

	        List<Avaliacao> avaliacoes = new ArrayList<>();
	        Connection  connection = Conexao.conectar();
	        PreparedStatement  pstm =null;
	        ResultSet resultSet = null;
	        
	        try {
	            String sql = "SELECT *FROM avaliacao;";
	            pstm = connection.prepareStatement(sql);
	         
	            resultSet = pstm.executeQuery();
	            
	            while (resultSet.next()) { 
	                
	                Avaliacao objAvaliacao = new Avaliacao();
	                objAvaliacao.setCodAluno(codAluno);             
	                
	                
	               avaliacoes.add(objAvaliacao);         
	            }
	        } catch (SQLException erro) {            
	            JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco",
	                    "Erro",JOptionPane.ERROR_MESSAGE); 
	        }  	
			System.out.println("Avaliacao");
	        return avaliacoes;
	        
			
	    	
	    }

		
			
		
	    
	    
	    
	    
	    

	 
	
} 