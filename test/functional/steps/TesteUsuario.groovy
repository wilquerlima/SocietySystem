package steps

import societysystem.Usuario
import societysystem.Grupo
import societysystem.UsuarioController
import societysystem.GrupoController


def createUsuario(def cpf, String nome, boolean isOwner, int idGrupo, def cont)
{
    cont.params << [cpf: cpf, nome: nome, isOwner: isOwner, idGrupo: idGrupo]
    cont.save()
    cont.response.reset
}

void createGrupo(String nome, int id, def cont)
{
    cont.params << [nome: nome, id: id]
    cont.save()
    cont.response.reset
}

boolean isUsuarioGrupo(def usu, def gru)
{
    if (usu.idGrupo == Grupo.findByNome(gru.nome))
    {
        return true
    }

    return false
}

void adicionaGrupo(def dono, def novo)
{
    if (dono.isOwner)
    {
        novo.idGrupo = dono.idGrupo
    }
}

boolean isOwnerGroup(def usu, String grupoNome)
{
    def grupo = Grupo.findByNome(grupoNome)

    if(grupo.id == usu.idGrupo && usu.isOwner)
    {
        return true;
    }

    return false
}