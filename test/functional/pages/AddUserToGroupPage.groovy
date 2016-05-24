package pages

import geb.Page

class AddUserToGroupPage extends Page
{
    static url = "/SocietySystem/Usuario"

    static at =
            {
                title =~ /adicionar pessoa a grupo/
            }

    void addPessoa(pessoa, addPessoa, grupo)
    {
        
    }

    void isMember(cpf, group)
    {

    }
}