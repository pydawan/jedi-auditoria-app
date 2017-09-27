package jedi.app.auditoria.model;

/**
 * @author thiago-amm
 * @version v1.0.0 26/09/2017
 * @since v1.0.0
 */
public enum EventoAuditoria {
   
   LISTAR("Listar", "LISTAR"),
   PESQUISAR("Pesquisar", "PESQUISAR"),
   ADICIONAR("Adicionar", "ADICIONAR"),
   EDITAR("Editar", "EDITAR"),
   REMOVER("Remover", "REMOVER"),
   SALVAR("Salvar", "SALVAR");
   
   private final String nome;
   private final String valor;
   
   private EventoAuditoria(String nome, String valor) {
      this.nome = nome;
      this.valor = valor;
   }
   
   public String getNome() {
      return nome;
   }
   
   public String getValor() {
      return valor;
   }
   
   public String nome() {
      return getNome();
   }
   
   public String valor() {
      return getValor();
   }
   
}
