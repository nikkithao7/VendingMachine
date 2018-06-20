<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet">        

    </head>
    <body>
        <div class="container">
            <h1>Vending Machine</h1>
            <hr/>
            <div id="candyScreen" class="col-md-9"> 
                <c:forEach var="candy" items="${candy}">
                    <form method="POST" action="selectItem">
                        <button type="submit" name="candyButton" value="${candy.id}" id="candyButtonStyle" class="col-md-4 btn">
                            <p class="pull-left"><c:out value="${candy.id}"/></p><br>
                            <p align="center"><c:out value="${candy.name}"/></p>
                            <p align="center">$<c:out value="${candy.cost}"/></p><br><br>
                            <p align="center">Quantity Left: <c:out value="${candy.quantity}"/></p>
                        </button>
                    </form>
                </c:forEach>    
            </div>

            <div id="infoScreen" class="col-md-3">
                <div id="moneyInsertView" class="col-md-12">
                    <p>Total $ In</p>
                    <form method="POST" action="addMoney">
                        <input id="inputId" name="moneyBox" value="${moneyInserted}" class="form-control" readOnly/>
                        <button name="addMoneyButton" value="1.00" type="submit" class="btn" id="moneybuttonStyle">
                            Add Dollar
                        </button>
                        <button name="addMoneyButton" value=".25" type="submit" class="btn" id="moneybuttonStyle">
                            Add Quarter
                        </button>
                        <button name="addMoneyButton" value=".10" type="submit" class="btn" id="moneybuttonStyle">
                            Add Dime
                        </button>
                        <button name="addMoneyButton" value=".05" type="submit" class="btn" id="moneybuttonStyle">
                            Add Nickel
                        </button>
                    </form>
                    <hr/>
                </div>

                <div id="moneyInsertView" class="col-md-12">
                    <p>Messages</p>
                    <input id="inputId" name="message" value="${message}" class="form-control" readOnly/>
                    <br>
                    <p>Item Selected</p>
                    <input id="inputId" name="item" value="${itemSelected}" class="form-control" readOnly/>
                    <form method="POST" action="makePurchase">
                        <button type="submit" class="btn" name="purchaseButton" id="purchaseButtonStyle">
                            Make Purchase
                        </button>
                    </form>
                    <hr/>
                </div>

                <div id="moneyInsertView" class="col-md-12" >
                    <p>Change</p>
                    <input id="inputId" name="changeReturned" value="${changeToDisplay}" class="form-control" readOnly/>
                    <form method="POST" action="getChange">
                        <button type="submit" class="btn" name="changeButton" id="changeButtonStyle">
                            Change Return
                        </button>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

