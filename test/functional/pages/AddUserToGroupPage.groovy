package pages

import geb.Page
import societysystem.GrupoController
import societysystem.Usuario
import societysystem.Grupo
import societysystem.UsuarioController

class AddUserToGroupPage extends Page
{
    static url = "/SocietySystem/Usuario/"

    static at =
    {
        title ==~ /Usuario Listagem/
    }

    def addPessoa(String pessoaCpf, String nomeGrupo)
    {
        GrupoController cont = new GrupoController()
        def usuario = Usuario.findByCpf(pessoaCpf)
        def grupo = Grupo.findByNome(nomeGrupo)
        if (usuario != null && grupo != null)
        {
            cont.addUsuario(usuario, grupo)
        }
    }

    boolean isMember(cpf, group)
    {
        def pessoa = Usuario.findByCpf(cpf)
        def grupo = Grupo.findByNome(group)

        if (pessoa != null && grupo != null)
        {
            grupo.getUsuarios().each {
                -> if (it.equals(pessoa))
                {
                    return true
                }

                return false
            }
        }

        return false
    }

    void  criarUsuario(cpf)
    {
        UsuarioController cont = new UsuarioController()
        cont.criarUsuario(cpf, "Carlos", false)
        cont.response.reset()
    }

    void criarGrupo(nome)
    {
        GrupoController gru = new GrupoController()
        gru.criarGrupo(nome, 1)
        gru.response.reset()
    }
}