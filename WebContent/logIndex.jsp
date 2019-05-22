<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>
            <head>
                <meta charset="UTF-8">
                <title>Insert title here</title>
                <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
                <style>
                    div {
                        border: 2px double;
                        text-align: center;
                    }
                    #wrapper {
                        width: 300px;
                    }
                    #wrapper2 {
                        width: 300px;
                    }
                </style>
            </head>
            <body>
                <c:choose>
                    <c:when test="${loginID!=null}"> 
                        <div id="wrapper2">
                            <div>${loginID} 님 환영합니다.</div>
                            <div>
                                <input type="button" value="마이페이지" id="myPage"> 
                                <input type="button" value="회원탈퇴" id="signOut"> 
                                <input type="button" value="로그아웃" id="logOut">
                            </div>
                        </div>
                        <script>
                            window.onload=function(){
                                document.getElementById("signOut").onclick=function(){ 
                                    var check = confirm("정말 삭제 하시겠습니까?");
                                    if(check){
                                        location.href="signOut.me"; 
                                    }else{
                                        location.href="goIndex.me";
                                    }
                                };
                                document.getElementById("logOut").onclick=function(){ 
                                    location.href="logout.me"; 
                                };
                                document.getElementById("myPage").onclick=function(){ 
                                    location.href="goMyPage.me"; 
                                };
                            };
                        </script>
                    </c:when>
                    <c:otherwise>
                        <div id="wrapper"> 
                            <form action="login.me"> 
                                <div>회원 로그인</div>
                                <div>
                                    <span>아이디 : </span> <input type="text" id="id" name="id">
                                </div>
                                <div>
                                    <span>비밀번호 : </span> <input type="password" id="pw" name="pw">
                                </div>
                                <div>
                                    <input id="loginBtn" type="submit" value="로그인"> 
                                    <input id="signBtn" type="button" value="회원가입"> 
                                </div>
                            </form>
                        </div>

                        <script>
                            window.onload=function(){
                                document.getElementById("signBtn").onclick=function(){
                                    location.href="goJoinForm.me";   
                                };
                            };
                        </script>
                    </c:otherwise>
                </c:choose>
            </body>
        </html>