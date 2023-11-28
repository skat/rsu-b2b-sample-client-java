<%@taglib uri="/struts-tags" prefix="s" %>
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
      <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">

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
          <div class="col-12">&nbsp;
          </div>
      </div>

      <div class="row">

          <div class="col-6">

              <div class="card">

                  <div class="card-header">
                      <b>Service Request</b>
                  </div>

                  <div class="card-body">

                      <s:form action="action" method="post">

                          <s:hidden name="serviceTestForm.requestMMF" id="request_mmf"/>
                          <s:hidden name="serviceTestForm.requestMKH" id="request_mkh"/>
                          <s:hidden name="serviceTestForm.requestVKH" id="request_vkh"/>

                          <div class="form-group">
                              <label for="service">Service</label>
                              <s:select
                                class="form-control"
                                list="serviceTestForm.services"
                                name="serviceTestForm.service"
                                id="service"
                                onchange="setRequest(this.value);"/>
                          </div>

                          <div class="form-group">
                              <label for="environment">Environment</label>
                              <s:select
                                class="form-control"
                                list="serviceTestForm.environments"
                                name="serviceTestForm.environment"
                                id="environment"/>
                          </div>

                          <div class="form-group">
                              <label for="certificate">Certificate</label>
                              <s:select
                                class="form-control"
                                list="serviceTestForm.certificates"
                                name="serviceTestForm.certificateAlias"
                                id="certificate"/>
                          </div>

                          <div class="form-group">
                              <label for="policy">Policy</label>
                              <s:select
                                class="form-control"
                                list="serviceTestForm.policiesList"
                                name="serviceTestForm.policy"
                                id="policy"/>
                          </div>

                          <div class="form-group">
                            <label for="txId">Override 'HovedOplysninger' (Transaction Id and Time)</label>
                            <s:checkbox id="txId" name="serviceTestForm.overrideTxInfo" />
                          </div>

                          <div class="form-group">
                            <label for="request">Request</label>
                            <s:textarea name="serviceTestForm.request" class="form-control" id="request" rows="16"></s:textarea>
                          </div>

                          <input type="submit" value="Test" class="btn btn-primary"/>

                      </s:form>

                  </div>

              </div>

          </div>

          <div class="col-6">

              <div class="card">

                  <div class="card-header">
                      <b>Service Response</b>
                  </div>

                  <div class="card-body">
                    <s:form name="response" action="#" method="get">
                      <textarea class="form-control" id="response" rows="24"><s:property value="serviceResponse"/></textarea>
                    </s:form>
                  </div>

              </div>

          </div>

      </div>

  </div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

    <script>
        function setRequest (selectedIndex) {
            if (selectedIndex.indexOf("ModtagMomsangivelseForeloebig") !== -1 )
            {
                document.getElementById('request').value = document.getElementById('request_mmf').value;
            }
            else
            {
                if (selectedIndex.indexOf("MomsangivelseKvitteringHent") !== -1 )
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
