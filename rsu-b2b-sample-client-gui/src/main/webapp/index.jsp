<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>RSU Sample GUI</title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${request.contextPath}/assets/css/starter-template.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="#">RSU Sample GUI</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        </ul>
    </div>
</nav>

<div class="container">

    <div class="row">
        <div class="col-12">
            &nbsp;
        </div>
    </div>

    <div class="row">
        <div class="col-6">
            <div class="card">
                <div class="card-header">
                    <b>Service Request</b>
                </div>
                <div class="card-body">
                    <html:messages id="msg_name" property="common.test.err">
                        <div class="alert alert-danger" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <bean:write name="msg_name"/>
                        </div>
                    </html:messages>
                    <html:form action="/serviceTest" method="post">
                        <html:hidden property="requestMMF" styleId="request_mmf"/>
                        <html:hidden property="requestMKH" styleId="request_mkh"/>
                        <html:hidden property="requestVKH" styleId="request_vkh"/>
                        <div class="form-group">
                            <label for="service">Service</label>
                            <html:select styleClass="form-control" property="service" styleId="service" onchange="setRequest(this.value);">
                                <html:optionsCollection name="serviceTestForm" property="services" label="label"
                                                        value="label"/>
                            </html:select>
                        </div>
                        <div class="form-group">
                            <label for="environment">Environment</label>
                            <html:select styleClass="form-control" property="environment" styleId="environment">
                                <html:optionsCollection name="serviceTestForm" property="environments" label="label"
                                                        value="label"/>
                            </html:select>
                        </div>
                        <div class="form-group">
                            <label for="certificate">Certificate</label>
                            <html:select styleClass="form-control" property="certificateAlias" styleId="certificate">
                                <html:optionsCollection name="serviceTestForm" property="certificates" label="label"
                                                        value="value"/>
                            </html:select>
                        </div>
                        <div class="form-group">
                            <label for="policy">Policy</label>
                            <html:select styleClass="form-control" property="policy" styleId="policy">
                                <html:optionsCollection name="serviceTestForm" property="policiesList" label="label"
                                                        value="value"/>
                            </html:select>
                        </div>
                        <div class="form-group">
                            <label for="txId">Override 'HovedOplysninger' (Transaction Id and Time)</label>
                            <html:checkbox styleClass="form-control" property="overrideTxInfo" styleId="txId">
                            </html:checkbox>
                        </div>
                        <div class="form-group">
                            <label for="request">Request</label>
                            <html:textarea styleClass="form-control" property="request" styleId="request" rows="16">
                            </html:textarea>
                        </div>
                        <input type="submit" value="Test" class="btn btn-primary"/>
                    </html:form>
                </div>
            </div>
        </div>
        <div class="col-6">
            <div class="card">
                <div class="card-header">
                    <b>Service Response</b>
                </div>
                <div class="card-body">
                    <html:messages id="msg_name" property="common.test.resp.err">
                        <div class="alert alert-danger" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <bean:write name="msg_name"/>
                        </div>
                    </html:messages>
                    <html:messages id="transactionId" property="downloadReceipt">
                        <div class="alert alert-info" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            Click <a href="${request.contextPath}/receipt?transactionId=<bean:write name="transactionId"/>">here</a> to download PDF.
                        </div>
                    </html:messages>
                    <html:messages id="confirmUrl" property="confirmUrl">
                        <div class="alert alert-info" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            Login <a href="<bean:write name="confirmUrl"/>">here</a> to confirm the submitted data.
                            (The link is the value of the path ModtagMomsangivelseForeloebig_O/Dybtlink/UrlIndicator)
                        </div>
                    </html:messages>
                    <form name="response" action="#" method="get">
                        <html:messages id="msg_response" property="lastResponse">
                            <div class="form-group">
                                <label for="response">Response</label>
                                <textarea class="form-control" id="response" rows="24"><bean:write name="msg_response"/>
                                </textarea>
                            </div>
                        </html:messages>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${request.contextPath}/assets/js/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="${request.contextPath}/assets/js/bootstrap.min.js"></script>

<script>
    function setRequest (selectedIndex) {
        if (selectedIndex.indexOf("ModtagMomsangivelseForeloebig") != -1 )
        {
            document.getElementById('request').value = document.getElementById('request_mmf').value;
        }
        else
        {
            if (selectedIndex.indexOf("MomsangivelseKvitteringHent") != -1 )
            {
                document.getElementById('request').value = document.getElementById('request_mkh').value;
            }
            else
            {
                document.getElementById('request').value = document.getElementById('request_vkh').value;
            }
        }
    }
</script>
</body>
</html>
