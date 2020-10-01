package br.com.digitalhouse


import java.util.*
import javax.xml.crypto.Data
import kotlin.collections.contains as contains


class  DigitalHouseManager() {
    var listaAlunos = mutableListOf<Aluno>()
    var listaProfessores = mutableListOf<Professor>()
    var listaCursos = mutableListOf<Curso>()
    var listaMatriculas = mutableListOf<Matricula>()

    //REGISTRAR E EXCLUIR CURSO
    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        var curso = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos)
        listaCursos.add(curso)
        println("Registro de Curso concluido")
    }

    fun excluirCurso(codigoCurso: Int) {
        for (curso in listaCursos) {
            if (curso.codigoCurso == codigoCurso) {
                listaCursos.remove(curso)
            }
        }
        println("Curso excluido")
    }

    //REGISTRAR E EXCLUIR PROFESSORES
    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val adjunto1 = ProfessorAdjunto(quantidadeDeHoras, nome, sobrenome, 0, codigoProfessor)
        listaProfessores.add(adjunto1)
        println("Registro de Professor Adjunto concluido")
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val prof = ProfessorTitular(especialidade, nome, sobrenome, 0, codigoProfessor)
        listaProfessores.add(ProfessorTitular(especialidade, nome, sobrenome, 0, codigoProfessor))
        println("Registro de Professor Titular concluido")

    }

    fun excluirProfessor(codigoProfessor: Int) {
        for (professor in listaProfessores) {
            if (professor.codigoProfessor == codigoProfessor) {
                listaProfessores.remove(professor)
            }
        }
        println("Professor excluido")
    }

    //REGISTRAR E MATRICULAR ALUNO
    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val aluno1 = Aluno(nome, sobrenome, codigoAluno)
        listaAlunos.add(aluno1)
        println("Registro de aluno concluido")
    }


    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        var aluno1 = Aluno(codigoAluno = codigoAluno)
        var curso1 = Curso(codigoCurso = codigoCurso)


        for (curso in listaCursos) {
            if (curso.codigoCurso == codigoCurso) {
                curso1 = curso
                println("Curso de codigo: $codigoCurso encontrado!")
            }
        }
        for (aluno in listaAlunos) {
            if (aluno.codigoAluno == codigoAluno) {
                aluno1 = aluno
                println("Aluno de codigo: $codigoAluno encontrado!")
            }
        }
        if (curso1.adicionarUmAluno(aluno1)) {
            var matricula1 = Matricula(aluno1, curso1, Date())
            listaMatriculas.add(matricula1)
            println("MATRICULA CONCLUIDA!")
        }else{
            println("Matricula n concluida,por falta de vagas!")
        }

    }
    //ALOCAR PROFESSORES
    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {

        for (professor in listaProfessores) {
            if (professor.codigoProfessor == codigoProfessorTitular) {
                for (curso in listaCursos) {
                    if (curso.codigoCurso == codigoCurso) {
                        professor as ProfessorTitular
                        curso.professorTitular = professor
                        println("Professor titular alocado")
                    }
                }
            } else if (professor.codigoProfessor == codigoProfessorAdjunto) {
                for (curso in listaCursos) {
                    if (curso.codigoCurso == codigoCurso) {
                        professor as ProfessorAdjunto
                        curso.professorAdjunto = professor
                        println("Professor adjunto alocado")
                    }
                }
            }
        }
    }



    //CONSULTAR O CURSO QUE ESTA MATRICULADO
    fun consultarCursoCadastrado(codigoAluno: Int) {
        var aluno1 = Aluno(codigoAluno = codigoAluno)
        var curso1 = Curso()

        for (aluno in listaAlunos) {
            if (aluno.codigoAluno == codigoAluno) {
                aluno1 = aluno
                for (curso in listaCursos) {
                    if (curso.listaAlunosMatriculados.contains(aluno1)) {
                        curso1 = curso
                        println("Aluno de codigo: $codigoAluno encontrado na lista de alunos do curso: ${curso1.nome}!")
                    }
                }

            }
        }
    }


    }




