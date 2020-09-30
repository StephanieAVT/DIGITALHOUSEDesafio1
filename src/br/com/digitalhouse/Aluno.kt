package br.com.digitalhouse

class Aluno(val nome:String ? = null,val sobrenome:String? = null,val codigoAluno:Int? = null) {

    override fun equals(other: Any?): Boolean {
        other as Aluno
        return this.codigoAluno == other.codigoAluno
    }

}