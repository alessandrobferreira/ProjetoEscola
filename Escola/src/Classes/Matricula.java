package Classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Util.Conexao;

/**
		 * @author +DEVS2BLU
		 */
		public class Matricula {
		    private int codAluno;
		    private int codDisciplina;
		    private Date dtMatricula;
		    private char statusMatricula;

		    
		    
		    
		    
		    public int getCodAluno() {
				return codAluno;
			}

			public void setCodAluno(int codAluno) {
				this.codAluno = codAluno;
			}

			public int getCodDisciplina() {
				return codDisciplina;
			}

			public void setCodDisciplina(int codDisciplina) {
				this.codDisciplina = codDisciplina;
			}

			public Date getDtMatricula() {
				return dtMatricula;
			}

			public void setDtMatricula(Date dtMatricula) {
				this.dtMatricula = dtMatricula;
			}

			public char getStatusMatricula() {
				return statusMatricula;
			}

			public void setStatusMatricula(char statusMatricula) {
				this.statusMatricula = statusMatricula;
			}

			/**
		     * 
		     */
		    public Boolean incluirMatricula() {
		       
		    	Connection con = Conexao.conectar();		
				String sql = "insert into matricula (codAluno, codDisciplina,"
						+ " dtMatricula, statusMatricula,) values(?,?,?,?)";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setInt(1, this.codAluno);
					stm.setInt(2, this.codDisciplina);
					stm.setDate(3, this.dtMatricula);
					stm.setString(4, String.valueOf(this.statusMatricula));					
					stm.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}        	
		    	
		  
		    	
		        
		        
		        return true;
		    	
		    }

		    /**
		     * 
		     */
		    
		    public void excluirMatricula() {
		        

		        Connection  connection = Conexao.conectar();
		        PreparedStatement  pstm =null;
		        
		        try {
		            String sql = "DELETE FROM matricula WHERE codAluno=?";
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
		        
		    	 public List<Matricula> consultarMatricula(Integer codAluno) {
		    	      
		    	    	
		        	 List<Matricula> matriculas = new ArrayList<>();
		             Connection  connection = Conexao.conectar();
		             PreparedStatement  pstm =null;
		             ResultSet resultSet = null;
		             
		             try {
		                 String sql = "SELECT *FROM matricula WHERE codAluno=?;";
		                 pstm = connection.prepareStatement(sql);
		                 pstm.setInt(1, this.codAluno);
		                 resultSet = pstm.executeQuery();
		                 
		                 while (resultSet.next()) { 
		                     
		                   Matricula objMatricula = new Matricula();
		                     objMatricula.setCodAluno(resultSet.getInt("codAluno"));
		                     objMatricula.setCodDisciplina(resultSet.getInt("codDisciplina"));
		                     objMatricula.setDtMatricula(resultSet.getDate("dtMatricula"));                                
		                     objMatricula.setStatusMatricula(resultSet.getNString("statusMatricula").charAt(0));
		                     
		                     matriculas.add(objMatricula);         
		                 }
		             } catch (SQLException erro) {            
		                 JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco",
		                         "Erro",JOptionPane.ERROR_MESSAGE); 
		             }  
		            
		             
		             return matriculas;
		        	
		        	
		        }

		        /**
		         * 
		         */
		    	
		    

		   
		       
		    	public List<Matricula>listarMatriculas() {

		            List<Matricula> matricula = new ArrayList<>();
		            Connection  connection = Conexao.conectar();
		            PreparedStatement  pstm =null;
		            ResultSet resultSet = null;
		            
		            try {
		                String sql = "SELECT *FROM matricula;";
		                pstm = connection.prepareStatement(sql);    
		                resultSet = pstm.executeQuery();
		                
		                while (resultSet.next()) { 
		                    
		                   Matricula objMatricula = new Matricula();
		                    objMatricula.setCodAluno(resultSet.getInt("CodAluno"));             
		                    
		                    
		                   matricula.add(objMatricula);         
		                }
		            } catch (SQLException erro) {            
		                JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco",
		                        "Erro",JOptionPane.ERROR_MESSAGE); 
		            }  	
		    		System.out.println("matricula");
		    		
		            return matricula;
		            
		    		
		        	
		        }

		    	
		    	
		    }