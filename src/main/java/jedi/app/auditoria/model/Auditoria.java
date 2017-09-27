package jedi.app.auditoria.model;

import java.util.Date;

import jedi.db.models.CharField;
import jedi.db.models.DateTimeField;
import jedi.db.models.Manager;
import jedi.db.models.Model;
import jedi.db.models.TextField;

/**
 * <p>
 * Cria registros de auditoria em um banco de dados relacional.
 * </p>
 * 
 * @author thiago-amm
 * @version v1.0.0 26/09/2017
 * @since v1.0.0
 */
public class Auditoria<T extends Model> extends Model {
   
   private static final long serialVersionUID = 1L;
   
   @CharField(max_length = 50)
   protected String evento;
   
   @TextField
   protected String objeto;
   
   @CharField(max_length = 255)
   protected String autor;
   
   @DateTimeField(auto_now_add = true, auto_now = true)
   protected Date data;
   
   public static Manager objects = new Manager(Auditoria.class);
   
   public Auditoria(T objeto, EventoAuditoria evento, String autor) throws IllegalArgumentException {
      setObjeto(objeto);
      setEvento(evento);
      setAutor(autor);
   }
   
   public Auditoria(T objeto, String autor) {
      this(objeto, EventoAuditoria.SALVAR, autor);
   }
   
   public String getEvento() {
      return evento;
   }
   
   public void setEvento(String evento) {
      evento = evento == null ? "" : evento;
      if (evento.isEmpty()) {
         throw new IllegalArgumentException("ATENÇÃO: o evento da auditoria não pode ser nulo ou vazio!");
      } else {
         this.evento = evento;
      }
   }
   
   public void setEvento(EventoAuditoria evento) {
      if (evento == null) {
         throw new IllegalArgumentException("ATENÇÃO: o evento da auditoria não pode ser nulo!");
      } else {
         this.evento = evento.getValor();
      }
   }
   
   public String evento() {
      return getEvento();
   }
   
   public Auditoria<T> evento(String evento) {
      setEvento(evento);
      return this;
   }
   
   public Auditoria<T> evento(EventoAuditoria evento) {
      setEvento(evento);
      return this;
   }
   
   public String getObjeto() {
      return objeto;
   }
   
   public void setObjeto(String objeto) {
      this.objeto = objeto;
   }
   
   public void setObjeto(T objeto) {
      this.objeto = objeto == null ? "" : objeto.toString();
   }
   
   public String objeto() {
      return getObjeto();
   }
   
   public Auditoria<T> objeto(String objeto) {
      setObjeto(objeto);
      return this;
   }
   
   public Auditoria<T> objeto(T objeto) {
      setObjeto(objeto);
      return this;
   }
   
   public String getAutor() {
      return autor;
   }
   
   public void setAutor(String autor) {
      this.autor = autor;
   }
   
   public String autor() {
      return getAutor();
   }
   
   public Auditoria<T> autor(String autor) {
      this.autor = autor;
      return this;
   }
   
   public Date getData() {
      return data;
   }
   
   public void setData(Date data) {
      this.data = data;
   }
   
   public Date data() {
      return getData();
   }
   
   public Auditoria<T> data(Date data) {
      setData(data);
      return this;
   }
   
}
