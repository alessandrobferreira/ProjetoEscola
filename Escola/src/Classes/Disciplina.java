package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Util.Conexao;

public class Disciplina {

	private int codDisciplina;
	private String nomDisciplina;
	private String nomProfessor;
	private int qtdAvaliacoes;

	
	
	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNomDisciplina() {
		return nomDisciplina;
	}

	public void setNomDisciplina(String nomDisciplina) {
		this.nomDisciplina = nomDisciplina;
	}

	public String getNomProfessor() {
		return nomProfessor;
	}

	public void setNomProfessor(String nomProfessor) {
		this.nomProfessor = nomProfessor;
	}

	public int getQtdAvaliacoes() {
		return qtdAvaliacoes;
	}

	public void setQtdAvaliacoes(int qtdAvaliacoes) {
		this.qtdAvaliacoes = qtdAvaliacoes;
	}

	/**
	 * 
	 */
		
		 public Boolean incluirDisciplina() {
		       
		    	Connection con = Conexao.conectar();		
				String sql = "insert into disciplina (codDisciplina, nomDisciplina,"
						+ " nomProfessor, qtdAvaliacoes,) values (?,?,?,?)";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setInt(1, this.codDisciplina);
					stm.setString(2, this.nomDisciplina);
					stm.setString(3, this.nomProfessor);
					stm.setInt(4, this.qtdAvaliacoes);					
					stm.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}        	
		    return true;
		    	
		    }

	/**
	 * 
	 */
		 
	public void alterarDisciplina() {
		

        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        
        try {
            String sql = "DELETE FROM disciplina WHERE codDisciplina =?";
            pstm = connection.prepareStatement(sql);
            
            pstm.setInt(1, this.codDisciplina);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro ao Deleta conta no banco",
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }    	
    	
    	
    }


	public void excluirDisciplina() {
		
    	

        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        
        try {
            String sql = "DELETE FROM disciplina WHERE codDisciplina=?";
            pstm = connection.prepareStatement(sql);
            
            pstm.setInt(1, this.codDisciplina);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro ao Deleta conta no banco",
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }    	
    	
    	
    }

		 public List<Disciplina> consultarDisciplina(Integer codDisciplina) {
   	      
	   	 List<Disciplina> disciplinas = new ArrayList<>();
	        Connection  connection = Conexao.conectar();
	        PreparedStatement  pstm =null;
	        ResultSet resultSet = null;
	        
	        try {
	            String sql = "SELECT *FROM Disciplina WHERE codDisciplina=?;";
	            pstm = connection.prepareStatement(sql);
	            pstm.setInt(1, this.codDisciplina);
	            resultSet = pstm.executeQuery();
	            
	            while (resultSet.next()) { 
	                
	            	Disciplina objDisciplina = new Disciplina();
	                objDisciplina.setCodDisciplina(resultSet.getInt("codDisciplina"));
	                objDisciplina.setNomDisciplina(resultSet.getString("NomDisciplina"));
	                objDisciplina.setNomProfessor(resultSet.getString("nomProfessor"));                                
	                objDisciplina.setQtdAvaliacoes(resultSet.getInt("qtdAvaliacoes"));
	                
	                disciplinas.add(objDisciplina);         
	            }
	        } catch (SQLException erro) {            
	            JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco",
	                    "Erro",JOptionPane.ERROR_MESSAGE); 
	        }  
	       
	        
	        return disciplinas;
	   	
	   	
		
		
	}

	
	
		
		public List<Disciplina>listarDisciplinas() {

            List<Disciplina> disciplina = new ArrayList<>();
            Connection  connection = Conexao.conectar();
            PreparedStatement  pstm =null;
            ResultSet resultSet = null;
            
            try {
                String sql = "SELECT *FROM disciplina;";
                pstm = connection.prepareStatement(sql);    
                resultSet = pstm.executeQuery();
                
                while (resultSet.next()) { 
                    
                	Disciplina objDisciplina = new Disciplina();
                    objDisciplina.setCodDisciplina(resultSet.getInt("codDisciplina"));             
                    objDisciplina.setNomDisciplina(resultSet.getString("NomDisciplina"));   
                    objDisciplina.setNomProfessor(resultSet.getString("nomProfessor"));
                    objDisciplina.setQtdAvaliacoes(resultSet.getInt("qtdAvaliacoes"));
                    disciplina.add(objDisciplina);         
                }
            } catch (SQLException erro) {            
                JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco",
                        "Erro",JOptionPane.ERROR_MESSAGE); 
            }  	
    		System.out.println("matricula");
    		
            return disciplina;
            
    		
        	
        }

    	
    	
    


		
		
		
	}

