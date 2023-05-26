package Entity;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import Servlet.NewMessageServlet;

public class ChatUser {
    // Имя пользователя
    private String name;
    private boolean TimeOut3 = true;
    private boolean TimeOut2 = true;
    private boolean TimeOut1 = true;
    public boolean GetTimeOut3() {
    	return TimeOut3;
    }
    public void SetTimeOut3(boolean T3) {
    	TimeOut3 = T3;
    }
    public boolean GetTimeOut2() {
    	return TimeOut2;
    }
    public void SetTimeOut2(boolean T2) {
    	TimeOut2 = T2;
    }
    public boolean GetTimeOut1() {
    	return TimeOut1;
    }
    public void SetTimeOut1(boolean T1) {
    	TimeOut1 = T1;
    }
    // Последнее время взаимодействия с сервером в количестве микросекунд,
// прошедших с 1 января 1970 года
    HttpServletResponse response;
    private long lastInteractionTime;
    private long LastSendMsg;
    // Идентификатор Java-сессии пользователя
    private String sessionId;
    public ChatUser(String name,long lastInteractionTime,String sessionId) {
        super();
        this.name = name;
        this.lastInteractionTime = lastInteractionTime;
        this.sessionId = sessionId;
        this.LastSendMsg = lastInteractionTime;
        
    }
    public void setResponse(HttpServletResponse response) throws IOException {
    	this.response = response;
    	//response.sendRedirect("/mychat/messages.do");
    }
    public HttpServletResponse getResponse() throws IOException {
    	return response;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getLastInteractionTime() {
        return lastInteractionTime;
    }
    public void setLastInteractionTime(long lastInteractionTime) {
        this.lastInteractionTime = lastInteractionTime;
    }
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public void setLastSendMsg(long LastSendMsg) {
        this.LastSendMsg = LastSendMsg;
    }
    public long getLastSendMsg() {
        return LastSendMsg;
    }
}
