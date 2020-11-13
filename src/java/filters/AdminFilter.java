 
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 809968
 */
public class AdminFilter implements Filter {
 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            HttpSession session = httpRequest.getSession();
              
            String email = (String)session.getAttribute("email");
            
            if(email == null){
                HttpServletResponse httpResponse = (HttpServletResponse)response;
                httpResponse.sendRedirect("login");
                return;
            }
            else if(email.equals("cprg352+admin@gmail.com")){
                 HttpServletResponse httpResponse = (HttpServletResponse)response;
                httpResponse.sendRedirect("notes");
                return;
            }
            
            chain.doFilter(request, response);//chain to the servlet / next filter
     
            
        }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
   }

    @Override
    public void destroy() {
    }
    
    
}
