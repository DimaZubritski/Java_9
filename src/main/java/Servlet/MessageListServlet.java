package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.ChatMessage;
import Entity.ChatUser;


public class MessageListServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
// Установить кодировку HTTP-ответа UTF-8
        response.setCharacterEncoding("utf8");
// Получить доступ к потоку вывода HTTP-ответа
        PrintWriter pw = response.getWriter();
// Записть в поток HTML-разметку страницы
        pw.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'/><meta http-equiv='refresh' content='10'></head>");
        pw.println("<body>");
        Iterator it = (Iterator) activeUsers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            //messages.add(new ChatMessage("Penetration begins", (ChatUser) pair.getValue(), Calendar.getInstance().getTimeInMillis()));
            ChatUser aUser = (ChatUser) pair.getValue();
            if(Calendar.getInstance().getTimeInMillis() - aUser.getLastSendMsg() > 1000 * 60 * 4) {
            	System.out.println(pair.getKey() + " : " + String.valueOf(Calendar.getInstance().getTimeInMillis() - aUser.getLastSendMsg()));
            	messages.add(new ChatMessage((String) pair.getKey() + ", penetration begins immideatly!", 
            			new ChatUser("System", Calendar.getInstance().getTimeInMillis(), request.getSession().getId()), Calendar.getInstance().getTimeInMillis()));
            	activeUsers.remove(pair.getKey());
            	continue;
            	//response.sendRedirect("/mychat/login.do");
            } else if(Calendar.getInstance().getTimeInMillis() - aUser.getLastSendMsg() > 1000 * 60 * 3 && aUser.GetTimeOut1() == true) {
            	System.out.println(pair.getKey() + " : " + String.valueOf(Calendar.getInstance().getTimeInMillis() - aUser.getLastSendMsg()));
            	messages.add(new ChatMessage("Hey, " + (String) pair.getKey() + " , you have 1 minet until i do penetration", 
            			new ChatUser("System", Calendar.getInstance().getTimeInMillis(), request.getSession().getId()), Calendar.getInstance().getTimeInMillis()));
            	aUser.SetTimeOut1(false);
            	continue;
            } else if(Calendar.getInstance().getTimeInMillis() - aUser.getLastSendMsg() > 1000 * 60 * 2 && aUser.GetTimeOut2() == true) {
            	System.out.println(pair.getKey() + " : " + String.valueOf(Calendar.getInstance().getTimeInMillis() - aUser.getLastSendMsg()));
            	messages.add(new ChatMessage("Hey, " + (String) pair.getKey() + " , you have 2 minets until i do penetration", 
            			new ChatUser("System", Calendar.getInstance().getTimeInMillis(), request.getSession().getId()), Calendar.getInstance().getTimeInMillis()));
            	aUser.SetTimeOut2(false);
            	continue;
            } else if(Calendar.getInstance().getTimeInMillis() - aUser.getLastSendMsg() > 1000 * 60 * 1 && aUser.GetTimeOut3() == true) {
            	System.out.println(pair.getKey() + " : " + String.valueOf(Calendar.getInstance().getTimeInMillis() - aUser.getLastSendMsg()));
            	messages.add(new ChatMessage("Hey, " + (String) pair.getKey() + " , you have 3 minets until i do penetration", 
            			new ChatUser("System", Calendar.getInstance().getTimeInMillis(), request.getSession().getId()), Calendar.getInstance().getTimeInMillis()));
            	aUser.SetTimeOut3(false);
            	continue;
            }
            //System.out.println(pair.getKey() + " = " + pair.getValue());
            
        }
// В обратном порядке записать в поток HTML-разметку для каждого сообщения
        
        for (int i=messages.size()-1; i>=0; i--) {
            ChatMessage aMessage = messages.get(i);
            if(aMessage.getAuthor().getName().equals("System")){
//            	/pw.println();
            	pw.println("<div style='color:#FF0000'><strong>" + aMessage.getAuthor().getName()
                        + "</strong>: " + aMessage.getMessage() +  "</div>");
            } else {
            	pw.println("<div><strong>" + aMessage.getAuthor().getName()
                        + "</strong>: " + aMessage.getMessage() + "</div>");
            }
            
            
        }
        pw.println("</body></html>");
    }
}
