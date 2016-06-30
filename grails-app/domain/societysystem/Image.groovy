package societysystem

class Image {
    byte[] arquivo
    //byte[] myFile
    static belongsTo=[pessoa:Pessoa]


    static constraints = {
        // Limit upload file size to 2MB
        arquivo maxSize: 1024 * 1024 * 2
        arquivo nullable: true

        arquivo blank:true

        // perfil defult: ""
        pessoa nullable:true, black:true
    }
}
