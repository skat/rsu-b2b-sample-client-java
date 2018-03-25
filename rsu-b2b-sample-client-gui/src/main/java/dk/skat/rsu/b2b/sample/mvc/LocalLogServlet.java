package dk.skat.rsu.b2b.sample.mvc;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;

/**
 * LocalLogServlet - Just an endpoint to receive a SOAP POST on localhost.
 * The response cannot be processed by the sample clients, but will return
 * a soap fault.
 *
 * @author SKAT
 * @since 1.0
 */
public class LocalLogServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LocalLogServlet.class.getName());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/xml");
        String requestAsString = IOUtils.toString(request.getReader());
        LOGGER.info("Received request: " + requestAsString);
        String responseAsString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "<env:Header/>\n" +
                "<env:Body>\n" +
                "<env:Fault>\n" +
                "<faultcode>env:Server</faultcode>\n" +
                "<faultstring>Request received, logged, but not processed. See logs for request submitted.</faultstring>\n" +
                "</env:Fault>\n" +
                "</env:Body>\n" +
                "</env:Envelope>";
        PrintWriter out = response.getWriter();
        out.println(responseAsString);
    }
}
