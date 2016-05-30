package pages

import geb.Page

class AddUserToGroupPage extends Page
{
    static url = "/SocietySystem/Usuario"

    static at =
            {
                title =~ /adicionar pessoa a grupo/
            }

    void addPessoa(pessoaCppf, addPessoaCpf, grupo)
    {
        //$("input", name: "name") = pessoaCppf
        //$("input", name: "name") = addPessoaCpf
    }

    void isMember(cpf, group)
    {

    }
}