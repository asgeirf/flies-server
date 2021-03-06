package net.openl10n.flies.model.po;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import net.openl10n.flies.model.HDocument;
import net.openl10n.flies.model.type.LocaleIdType;

import org.fedorahosted.flies.common.LocaleId;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

/**
 * 
 * @author sflaniga@redhat.com
 * @see org.fedorahosted.flies.rest.dto.po.PoTargetHeader
 */
@Entity
@TypeDef(name = "localeId", typeClass = LocaleIdType.class)
public class HPoTargetHeader extends AbstractPoHeader
{

   private static final long serialVersionUID = 1L;

   private LocaleId targetLanguage;
   private HDocument document;

   public void setTargetLanguage(LocaleId targetLanguage)
   {
      this.targetLanguage = targetLanguage;
   }

   @NaturalId
   @Type(type = "localeId")
   @NotNull
   public LocaleId getTargetLanguage()
   {
      return targetLanguage;
   }

   public void setDocument(HDocument document)
   {
      this.document = document;
   }

   @NaturalId
   @ManyToOne
   @JoinColumn(name = "document_id")
   public HDocument getDocument()
   {
      return document;
   }

   /**
    * Used for debugging
    */
   @Override
   public String toString()
   {
      return "HPoTargetHeader(" + super.toString() + "lang:" + getTargetLanguage() + ")";
   }

}
