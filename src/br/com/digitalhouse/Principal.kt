package br.com.digitalhouse


import java.util.*

fun main() {

    val dh = DigitalHouseManager()



    //REGISTRO DE ALUNOS
    println("===REGISTRO DE ALUNOS=====")
    dh.registrarAluno("Enzo","Gabriel",1)
    dh.registrarAluno("Maria","Alice",2)
    dh.registrarAluno("Valentina","Maria",3)
    dh.registrarAluno("Joao","Vitor",4)
    dh.registrarAluno("Rafael","A",5)



    //REGISTRO DE PROFS
    println("===REGISTRO DE PROFESSORES=====")
    dh.registrarProfessorAdjunto("Jose","Silva",11,10)
    dh.registrarProfessorAdjunto("Maria","Fernanda",22,11)

    dh.registrarProfessorTitular("Antonio","Vieira",33,"WEB")
    dh.registrarProfessorTitular("Margarida","v",44,"POO")


    //REGISTRO DE CURSOS
    println("===REGISTRO DE CURSOS=====")
    dh.registrarCurso("Full Stack",2001,3)
    dh.registrarCurso("Android",2002,2)

    //ALOCAR UM PROF TITULAR E ADJ P CADA CURSO
    println("===ALOCANDO PROFESSOR TITULAR E ADJUNTO=====")
    dh.alocarProfessores(2001,33,11)
    dh.alocarProfessores(2002,44,22)


    //Matricular 2 alunos full stack
    println("===MATRICULAS=====")

    dh.matricularAluno(1,2001)
    dh.matricularAluno(2,2001)


    //Matricular 3 alunos android
    dh.matricularAluno(3,2002)
    dh.matricularAluno(4,2002)
    dh.matricularAluno(5,2002)


    //Consultar
    println("==========")
    dh.consultarCursoCadastrado(2)



}