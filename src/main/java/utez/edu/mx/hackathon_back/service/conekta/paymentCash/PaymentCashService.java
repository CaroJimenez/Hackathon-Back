package utez.edu.mx.hackathon_back.service.conekta.paymentCash;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.hackathon_back.model.conekta.paymentCash.PaymentCash;
import utez.edu.mx.hackathon_back.model.conekta.paymentCash.PaymentCashRepository;
import utez.edu.mx.hackathon_back.model.conekta.tickeyOxxo.TicketOxxo;


@Service
@Transactional
public class PaymentCashService {
    @Autowired
    private PaymentCashRepository repository;

    public utez.edu.mx.hackathon_back.utils.Response<TicketOxxo> createOxxoPayment(PaymentCash paymentCash) {
        try {
            AsyncHttpClient client = new DefaultAsyncHttpClient();
            String requestBody = String.format(
                    "{\"customer_info\":{\"name\":\"%s\",\"email\":\"%s\",\"phone\":\"%s\"},\"pre_authorize\":false,\"charges\":[{\"payment_method\":{\"type\":\"cash\"}}],\"currency\":\"MXN\",\"line_items\":[{\"antifraud_info\":{\"newKey\":\"New Value\"},\"name\":\"BONANZA PAYMENT\",\"quantity\":1,\"unit_price\":%s}]}",
                    paymentCash.getCustomer_name(), paymentCash.getCustomer_email(), paymentCash.getCustomer_phone(), paymentCash.getAmount()
            );
            Response response = client.prepare("POST", "https://api.conekta.io/orders")
                    .setHeader("accept", "application/vnd.conekta-v2.1.0+json")
                    .setHeader("content-type", "application/json")
                    .setHeader("authorization", "Bearer key_mRtflzDbQGCMAp3vMMKzvEs")
                    .setBody(requestBody)
                    .execute()
                    .toCompletableFuture()
                    .join();
            client.close();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.getResponseBody());
            String barcode_url = jsonNode.at("/charges/data/0/payment_method/barcode_url").asText();
            String reference = jsonNode.at("/charges/data/0/payment_method/reference").asText();
            Integer expires_at = jsonNode.at("/charges/data/0/payment_method/expires_at").asInt();
            Integer created_at = jsonNode.at("/charges/data/0/created_at").asInt();

            TicketOxxo ticketOxxo = new TicketOxxo();
            ticketOxxo.setBarcode_url(barcode_url);
            ticketOxxo.setReference(reference);
            ticketOxxo.setExpires_at(expires_at);
            ticketOxxo.setCreated_at(created_at);

            return new utez.edu.mx.hackathon_back.utils.Response<>(
                    ticketOxxo,
                    false,
                    200,
                    "OK"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
