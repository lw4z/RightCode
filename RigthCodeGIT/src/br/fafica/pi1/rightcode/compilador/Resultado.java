package br.fafica.pi1.rightcode.compilador;

//import br.fafica.pi1.rightcode.aluno.Aluno;
import br.fafica.pi1.rightcode.disciplina.Disciplina;
import java.util.ArrayList;
import java.util.Date;

public class Resultado {

   
	
	private String caminho;
	private String compilou;
	private ArrayList <BuscaFiltro> buscaFiltro;
	private Date data;
	private String erro;
        private Disciplina disciplina;

   
	
	public Resultado(String caminho,boolean compilou,String erro, Disciplina disciplina){
		if(compilou){
			this.compilou = "Arquivo Compilador com Sucesso";
		}else{
			this.compilou = "Arquivo Não compilado";
		}
		this.disciplina=disciplina;
		this.caminho = caminho;
		this.buscaFiltro = null;
		this.data = new Date();
		this.erro = erro;
	}
		
	public String getCaminho() {
		return caminho;
	}
        
        public Disciplina getDisciplina() {
        return disciplina;
       }
        
       public void setAluno(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	public String isCompilou() {
		return compilou;
	}

	public void setCompilou(boolean compilou) {
		if(compilou){
			this.compilou = "Arquivo Compilador com Sucesso";
		}else{
			this.compilou = "Arquivo Não compilado";
		}
	}

	public ArrayList<BuscaFiltro> getBuscaFiltro() {
		//if(buscaFiltro == null) buscaFiltro = new ArrayList<>();
		return buscaFiltro;
	}

	public void setBuscaFiltro(BuscaFiltro busca) {
		if(buscaFiltro == null) buscaFiltro = new ArrayList<>();
		this.buscaFiltro.add(busca);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	private String arrayString(){
		String guardar = "";
		for(BuscaFiltro q : buscaFiltro){
			guardar += q+"\n";
		}
		
		return guardar;
	}

//return "Data: "+this.data+"\nCaminho do Arquivo: "+this.caminho+"\nCompila��o: "+this.compilou+"\n";
	public String toString(){
		if(buscaFiltro == null){
			return "####################################################\n"+
					"Data: "+this.data +"\nDisciplina: "+this.disciplina.getNome()+"\n"+"Caminho do Arquivo: "+this.caminho + "\nCompilação: "+this.compilou+"\n"+this.erro;
		}else{
			return "####################################################\n"+
					"Data: "+this.data +"\nDiscip´lina: "+this.disciplina.getNome()+"\n"+"Caminho do Arquivo: "+this.caminho + "\nCompilação: "+this.compilou+
					"\n"+arrayString()+""+this.erro;
		}
	}
	

}
