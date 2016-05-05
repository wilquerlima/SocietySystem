import steps.BancoPessoa
import steps.BancoGrupo
import steps.TesteBancoGrupo

import static cucumber.api.groovy.pt.*


Given (~'^"([^"]*)" é um usuário cadastrado no sistema$')
        {
            nome ->
                def pessoa = BancoPessoa.findbyNome(nome)
                assert pessoa == null
        }

Given(~'^"([^"]*)"  tem um grupo com usuários "([^"]*)"$')
        {
            nome, nomeGrupo ->
                def pessoa = BancoPessoa.findbyNome(nome)
                assert pessoa == null
                def grupo = BancoGrupo.findbyNome(nomeGrupo)
                assert grupo == null
                assert grupo.getAdm(nome) == null
        }

When(~'^"([^"]*)" adicionar "([^"]*)" ao grupo "([^"]*)"$')
        {
            p1, p2, nomeGrupo ->
                def grupo = TesteBancoGrupo
        }

Then(~'^"([^"]*)" passará a receber convites de jogos de "([^"]*)" destinados ao grupo "([^"]*)"$')
        {
            p1, p2, nomeGrupo ->
                def grupo = BancoGrupo.findbyNome(nomeGrupo)

        }