package pages

import geb.Page

class AddUserToGroupPage extends Page
{
    static url = "/SocietySystem/Usuario/"

    static at =
    {
        title ==~ /Usuario Listagem/
    }

    def addPessoa(pessoaCppf, addPessoaCpf, grupo)
    {
        //$("input", name: "name") = pessoaCppf
        //$("input", name: "name") = addPessoaCpf
    }

    void isMember(cpf, group)
    {

    }
}