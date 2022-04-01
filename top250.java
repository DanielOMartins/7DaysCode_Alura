import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class top250 {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://imdb-api.com/en/API/Top250Movies/k_51lbp123");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            conexao.setRequestMethod("GET");
            conexao.setRequestProperty("accept", "application/json");

            if(conexao.getResponseCode() != 200){
                throw new RuntimeException("Erro :" + conexao.getResponseCode());
            }

            InputStreamReader entrada = new InputStreamReader(conexao.getInputStream());
            BufferedReader br = new BufferedReader(entrada);

            String saida;
            while((saida = br.readLine()) != null){
                System.out.println(saida);
            }
            conexao.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet: " + e);
        }
        
        
    }
}