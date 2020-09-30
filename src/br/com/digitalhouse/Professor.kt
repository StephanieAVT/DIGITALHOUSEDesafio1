package br.com.digitalhouse

abstract class Professor(val nome:String?=null,val sobrenome:String?=null ,var tempoDeCasa:Int ?=null, val codigoProfessor: Int?=null ) {

    override fun equals(other: Any?): Boolean {
        other as Professor
        return this.codigoProfessor == other.codigoProfessor
    }
}