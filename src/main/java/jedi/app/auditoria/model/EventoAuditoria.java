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
   
   private EventoAuditoria(String nome) {
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
      for (EventoAuditoria eventoAuditoria : EventoAuditoria.values()) {
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
      for (EventoAuditoria eventoAuditoria : EventoAuditoria.values()) {
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
   
   public static EventoAuditoria getRandom() {
      Random random = new Random();
      EventoAuditoria eventoAuditoria = EventoAuditoria.values()[random.nextInt(EventoAuditoria.values().length)];
      return eventoAuditoria;
   }
   
   public static EventoAuditoria random() {
      return getRandom();
   }
   
}
