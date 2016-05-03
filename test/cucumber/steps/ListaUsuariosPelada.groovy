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
            p1, p2, grupo ->

        }