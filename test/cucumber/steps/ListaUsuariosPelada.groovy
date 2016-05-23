import static cucumber.api.groovy.pt.*

import cucumber.api.PendingException

import steps.TesteUsuario
import societysystem.UsuarioController
import societysystem.GrupoController
import societysystem.Usuario

Given (~'^"([^"]*)" é um grupo pertencente ao usuario de cpf "([^"]*)"$')
        {
            String grupo, cpf ->
            def t = new TesteUsuario()
            def contGrupo = new GrupoController()
            def contUsuario = new UsuarioController()
            t.createGrupo(grupo, 1, contGrupo)
            t.createUsuario(cpf, 'andre', true, 1, contUsuario)
            def usu = Usuario.findByCpf(cpf)
            def gru = Grupo.finfByNome(grupo)
            assert usu == false
            assert gru == false
            assert t.isUsuarioGrupo(usu, gru) == false
        }

And (~'^"([^"]*)" não cpf de um usuário cadastrado no sistema$')
        {
            String cpf ->
                assert Usuario.findByCpf(cpf) == true
        }

When (~'^"([^"]*)" tenta adicionar "([^"]*)" ao grupo "([^"]*)"$')
        {
            Sting usu1, usu2, grupo ->
                def t = new TesteUsuario()
                assert t.isOwnerGroup(usu1, grupo) == false
                t.adicionaGrupo(usu1, usu2)
        }

Then (~'^O sistema não adiciona "([^"]*)"$')
        {
            String cpf ->
            def usu = Usuario.findByCpf(cpf)
            assert usu == true
            assert usu.idGrupo != 0
        }







Give (~'^O usuario de cpf "([^"]*)" está no página de adicionar usuário ao grupo "([^"]*)"$')
        {

        }

And(~'^O usuario de cpf "([^"]*)" não aparece na lista de pessoas aptas a ser adicionadas$')
        {

        }

When(~'"([^"]*)" tenta adicionar "([^"]*)"$')
        {

        }

Then(~'^Uma mensagem de erro é exibida$')
        {

        }
