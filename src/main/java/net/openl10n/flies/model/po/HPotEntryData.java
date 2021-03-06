package net.openl10n.flies.model.po;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import net.openl10n.flies.model.HSimpleComment;
import net.openl10n.flies.model.HTextFlow;

import org.hibernate.annotations.NaturalId;

/**
 * 
 * @author sflaniga@redhat.com
 * @see org.fedorahosted.flies.rest.dto.po.PotEntryData
 */
@Entity
public class HPotEntryData implements Serializable
{

   private static final long serialVersionUID = 1L;

   private Long id;
   private HTextFlow textFlow;
   private String context;
   private HSimpleComment extractedComment;
   private String flags;
   private String references;

   public HPotEntryData()
   {
   }

   @Id
   @GeneratedValue
   public Long getId()
   {
      return id;
   }

   protected void setId(Long id)
   {
      this.id = id;
   }

   public void setTextFlow(HTextFlow textFlow)
   {
      this.textFlow = textFlow;
   }

   @OneToOne
   @JoinColumn(name = "tf_id", /* nullable=false, */unique = true)
   @NaturalId
   public HTextFlow getTextFlow()
   {
      return textFlow;
   }

   public void setContext(String context)
   {
      this.context = context;
   }

   public String getContext()
   {
      return context;
   }

   public void setExtractedComment(HSimpleComment extractedComment)
   {
      this.extractedComment = extractedComment;
   }

   @OneToOne(optional = true, cascade = CascadeType.ALL)
   @JoinColumn(name = "comment_id")
   public HSimpleComment getExtractedComment()
   {
      return extractedComment;
   }

   // delimited by ','
   public void setFlags(String flags)
   {
      this.flags = flags;
   }

   public String getFlags()
   {
      return flags;
   }

   // delimited by ' '
   public void setReferences(String references)
   {
      this.references = references;
   }

   @Column(name = "refs")
   public String getReferences()
   {
      return references;
   }

}
