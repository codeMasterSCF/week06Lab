package business;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 463849
 */
public class DebugTag extends TagSupport {
    
     @Override
    public int doStartTag() throws JspException {
        
        ServletRequest request =pageContext.getRequest();
        String url = request.getServerName();
        
        
        if(url.contains("test")||url.contains("localhost")){
            String query = request.getParameter("debug");
            
            if(query!=null){
                
                return EVAL_BODY_INCLUDE;
                
            }
        
        }
             
        return SKIP_BODY;
    }
    
}
