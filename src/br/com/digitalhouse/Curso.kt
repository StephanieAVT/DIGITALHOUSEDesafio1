package br.com.digitalhouse

class Curso(val nome:String?=null,val codigoCurso:Int?=null,var quantidadeMaximaAlunos:Int?=null){
    var listaAlunosMatriculados = mutableListOf<Aluno>()
    var professorTitular:ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null


    override fun equals(other: Any?): Boolean {
        other as Curso
        return  this.codigoCurso == other.codigoCurso
    }

    fun adicionarUmAluno(umAluno:Aluno):Boolean {
        if(this.listaAlunosMatriculados.size < quantidadeMaximaAlunos!!){
            this.listaAlunosMatriculados.add(umAluno)
            return true
        }else{
            return false
        }
    }

    fun excluirAluno(umAluno: Aluno){
        listaAlunosMatriculados!!.remove(umAluno)

    }
}