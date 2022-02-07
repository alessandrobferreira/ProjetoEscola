package Classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.Conexao;

public class Aluno {

    public Aluno() {
    }

    private int codAluno;
    private String nomeAluno;
    private String nomeMae;
    private String nomePai;
    private Date dataNasc;
    private double medAluno;
    private String sitAluno;
    
    // Construtor
    public Aluno(int codAluno, String nomeAluno, String nomeMae, String nomePai, Date dataNasc, double medAluno,
			String sitAluno) {
		super();
		this.codAluno = codAluno;
		this.nomeAluno = nomeAluno;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		this.dataNasc = dataNasc;
		this.medAluno = medAluno;
		this.sitAluno = sitAluno;
	}

	public boolean incluirAluno(Aluno aluno) {
    	Connection con = Conexao.conectar();		
		String sql = "insert into aluno(nomeAluno, nomeMae,"
				+ " nomePai, dataNasc, medAluno, sitAluno) values(?,?,?,?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, this.nomeAluno);
			stm.setString(2, this.nomeMae);
			stm.setString(3, this.nomePai);
			stm.setDate(4, this.dataNasc);
			stm.setDouble(5, this.medAluno);	
			stm.setString(6, this.sitAluno);					
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco.");
			e.printStackTrace();
		}   
		return true;
    }

    public boolean alterarAluno(Aluno aluno) {
        String sql = "update aluno set nomeAluno = ?, nomeMae = ?, nomePai = ?,"
        		+ "dataNasc = ?, medAluno = ?, sitAluno = ? where codaluno = ?";
        try {
			PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
			ps.setString(1, this.nomeAluno);
			ps.setString(2, this.nomeMae);
			ps.setString(3, this.nomePai);
			ps.setDate(4, this.dataNasc);
			ps.setDouble(5, this.medAluno);
			ps.setString(6, this.sitAluno);
			ps.setInt(7, this.codAluno);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return true;
    }

    public boolean excluirAluno(int codAluno) {
        String sql = "delete from aluno where id = ?";
        try {
			PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
			ps.setInt(1, this.codAluno);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return true;
    }

    public Aluno consultarAluno(int id) {
        String sql = "select * from aluno where codaluno = " + id;
        Aluno aluno = new Aluno();
        try {
			PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				aluno.setCodAluno(rs.getInt("codAluno"));
				aluno.setNomeAluno(rs.getString("nomeAluno"));
				aluno.setNomeMae(rs.getString("nomeMae"));
				aluno.setNomePai(rs.getString("nomePai"));
				aluno.setDataNasc(rs.getDate("dataNasc"));
				aluno.setMedAluno(rs.getDouble("medAluno"));
				aluno.setSitAluno(rs.getString("sitAluno"));
				System.out.println(aluno);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aluno;
    }

    @Override
	public String toString() {
		return "Aluno [codAluno=" + codAluno + ", nomeAluno=" + nomeAluno + ", nomeMae=" + nomeMae + ", nomePai="
				+ nomePai + ", dataNasc=" + dataNasc + ", medAluno=" + medAluno + ", sitAluno=" + sitAluno + "]";
	}

	public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "select * from aluno";
        try {
			PreparedStatement stmt = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			try {
				while (rs.next()) {
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}					
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return alunos;
    }
    
    
    // Getters and setters
	public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public double getMedAluno() {
		return medAluno;
	}

	public void setMedAluno(double medAluno) {
		this.medAluno = medAluno;
	}

	public String getSitAluno() {
		return sitAluno;
	}

	public void setSitAluno(String sitAluno) {
		this.sitAluno = sitAluno;
	}
    
    

}