package steps

import societysystem.Grupo
import societysystem.Usuario
import societysystem.UsuarioController
import societysystem.GrupoController

boolean hasMember(String groupName)
{
    Grupo grupo = Grupo.findByNome(groupName)

    if (grupo != null && grupo.getUsuarios() != null)
    {
        return true
    }

    return false
}

boolean isMember(String usuarioCPF, String grupoNome)
{
    def usu = Usuario.findByCpf(usuarioCPF)
    def gru = Grupo.findByNome(grupoNome)

    if (gru.getUsuarios().)
}