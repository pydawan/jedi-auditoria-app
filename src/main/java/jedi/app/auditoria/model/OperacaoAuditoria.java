package jedi.app.auditoria.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author thiago-amm
 * @version v1.0.0 26/09/2017
 * @version v1.0.1 07/10/2017
 * @version v1.0.2 09/11/2017
 * @since v1.0.0
 */
public enum OperacaoAuditoria {
   
   ADICIONAR("Adicionar", "ADICIONAR"),
   EDITAR("Editar", "EDITAR"),
   REMOVER("Remover", "REMOVER"),
   SALVAR("Salvar", "SALVAR"),
   CONSULTAR("Consultar", "CONSULTAR"),
   BUSCAR("Buscar", "BUSCAR"),
   PESQUISAR("Pesquisar", "PESQUISAR"),
   LISTAR("Listar", "LISTAR"),
   VISUALIZAR("Visualizar", "VISUALIZAR"),
   VER("Ver", "VER"),
   PAGINAR("Paginar", "PAGINAR"),
   IMPRIMIR("Imprimir", "IMPRIMIR"),
   ENVIAR_EMAIL("Enviar E-mail", "ENVIAR_EMAIL"),
   INSERIR("Inserir", "INSERIR"),
   ATUALIZAR("Atualizar", "ATUALIZAR"),
   EXCLUIR("Excluir", "EXCLUIR"),
   SELECIONAR("Selecionar", "SELECIONAR"),
   MARCAR("Marcar", "MARCAR"),
   GRAVAR("Gravar", "GRAVAR"),
   ATIVAR("Ativar", "ATIVAR"),
   INATIVAR("Inativar", "INATIVAR");
   
   private final String nome;
   private final String valor;
   
   private OperacaoAuditoria(String nome, String valor) {
      this.nome = nome;
      this.valor = valor;
   }
   
   private OperacaoAuditoria(String nome) {
      this.nome = nome;
      this.valor = nome == null ? null : nome.toUpperCase();
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
   
   public static Map<String, String> getMap() {
      Map<String, String> map = new HashMap<>();
      for (OperacaoAuditoria eventoAuditoria : OperacaoAuditoria.values()) {
         map.put(eventoAuditoria.getNome(), eventoAuditoria.getValor());
      }
      return map;
   }
   
   public static Map<String, String> map() {
      return getMap();
   }
   
   public static List<Map<String, String>> getOptions() {
      List<Map<String, String>> options = new ArrayList<>();
      Map<String, String> option = null;
      for (OperacaoAuditoria eventoAuditoria : OperacaoAuditoria.values()) {
         option = new HashMap<>();
         option.put("nome", eventoAuditoria.getNome());
         option.put("valor", eventoAuditoria.getValor());
         options.add(option);
      }
      return options;
   }
   
   public static List<Map<String, String>> options() {
      return getOptions();
   }
   
   public static OperacaoAuditoria getRandom() {
      Random random = new Random();
      OperacaoAuditoria eventoAuditoria = OperacaoAuditoria.values()[random.nextInt(OperacaoAuditoria.values().length)];
      return eventoAuditoria;
   }
   
   public static OperacaoAuditoria random() {
      return getRandom();
   }
   
}
