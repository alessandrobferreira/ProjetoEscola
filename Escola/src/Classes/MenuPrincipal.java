package Classes;

import java.sql.Date;
import java.util.List;

import Util.Conexao;

public class MenuPrincipal {

	public static void main(String[] args) {
		
		if(Conexao.conectar()!= null) {
			System.out.println("Conectei. Uffa. Finalmente");
			
			
		}
		

	}
	
	public static void excluirAluno() {
		Aluno aluno = new Aluno();
		if(aluno.excluirAluno(1)) {
			System.out.println("Aluno excluído com sucesso.");
		} else {
			System.out.println("Erro ao excluir aluno.");
		}
		
	}
	
	public static void  consultarId() {
		
		Aluno aluno = new Aluno();
        aluno = aluno.consultarAluno(2);
		System.out.println(aluno.getCodAluno());
		System.out.println(aluno.getMedAluno());
		System.out.println(aluno.getNomeAluno());
		System.out.println(aluno.getNomeMae());
		System.out.println(aluno.getNomePai());
		System.out.println(aluno.getSitAluno());
		System.out.println(aluno.getDataNasc());

		
		System.out.println("");
		
				
	}
	 
	static void pesquisarTodos(){
		Aluno aluno = new Aluno();
		List<Aluno> listaAluno = aluno.listarAlunos();
		for(Aluno a: listaAluno) {
		System.out.println(a.getCodAluno());
		System.out.println(a.getMedAluno());
		System.out.println(a.getNomeAluno());
		System.out.println(a.getNomeMae());
		System.out.println(a.getNomePai());
		System.out.println(a.getSitAluno());
		System.out.println(a.getDataNasc());
			
		}
	
	}
	
		
	public static void alterarAluno() {
		Aluno aluno = new Aluno();
		aluno.setCodAluno(1);
		aluno.setDataNasc(Date.valueOf("1992-03-03"));
		aluno.setMedAluno(9);
		aluno.setNomeAluno("Marcus Vinicius");
		aluno.setNomeMae("Denise");
		aluno.setNomePai("Modesto");
		aluno.setSitAluno("S");
		
		if(aluno.alterarAluno(aluno)) {
			System.out.println("Aluno alterado com sucesso.");			
		} else {
			System.out.println("Erro ao alterar aluno.");
		}
		
	}
	
	public static void incluirAluno() {
		Aluno aluno = new Aluno();		
		aluno.setDataNasc(Date.valueOf("1983-05-03"));
		aluno.setMedAluno(10);
		aluno.setNomeAluno("Fernando Marcos");
		aluno.setNomeMae("Maria");
		aluno.setNomePai("Jose");
		aluno.setSitAluno("S");
		
		
		if(aluno.incluirAluno(aluno)) {
			System.out.println("Aluno incluído com sucesso.");			
		} else {
			System.out.println("Erro ao incluir aluno.");
		}
			
	}
}
