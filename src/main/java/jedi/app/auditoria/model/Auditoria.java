package jedi.app.auditoria.model;

import java.util.Date;

import jedi.db.models.CharField;
import jedi.db.models.DateTimeField;
import jedi.db.models.Manager;
import jedi.db.models.Model;
import jedi.db.models.TextField;

/**
 * Cria registros de auditoria em um banco de dados relacional.
 * 
 * @author thiago-amm
 * @version v1.0.0 26/09/2017
 * @version v1.0.1 07/10/2017
 * @version v1.0.2 09/11/2017
 * @since v1.0.0
 */
public class Auditoria<T extends Model> extends Model {
   
   private static final long serialVersionUID = 1L;
   
   @CharField(max_length = 50)
   protected String operacao;
   
   @TextField
   protected String objeto;
   
   @CharField(max_length = 255)
   protected String autor;
   
   @DateTimeField(auto_now_add = true, auto_now = true)
   protected Date data;
   
   public static Manager objects = new Manager(Auditoria.class);
   
   public Auditoria(T objeto, OperacaoAuditoria operacao, String autor) throws IllegalArgumentException {
      setObjeto(objeto);
      setOperacao(operacao);
      setAutor(autor);
   }
   
   public Auditoria(T objeto, String autor) {
      this(objeto, OperacaoAuditoria.SALVAR, autor);
   }
   
   public static <T extends Model> Auditoria<T> of(T objeto, OperacaoAuditoria operacao, String autor)
         throws IllegalArgumentException {
      return new Auditoria<T>(objeto, operacao, autor);
   }
   
   public static <T extends Model> Auditoria<T> of(T objeto, String autor) {
      return new Auditoria<T>(objeto, autor);
   }
   
   public String getOperacao() {
      return operacao;
   }
   
   public void setOperacao(String operacao) {
      operacao = operacao == null ? "" : operacao;
      if (operacao.isEmpty()) {
         throw new IllegalArgumentException("ATENÇÃO: a operação auditada não pode ser nula ou vazia!");
      } else {
         this.operacao = operacao;
      }
   }
   
   public void setOperacao(OperacaoAuditoria operacao) {
      if (operacao == null) {
         throw new IllegalArgumentException("ATENÇÃO: a operação auditada não pode ser nula!");
      } else {
         this.operacao = operacao.getValor();
      }
   }
   
   public String operacao() {
      return getOperacao();
   }
   
   public Auditoria<T> operacao(String operacao) {
      setOperacao(operacao);
      return this;
   }
   
   public Auditoria<T> operacao(OperacaoAuditoria operacao) {
      setOperacao(operacao);
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
