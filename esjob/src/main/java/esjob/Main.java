package esjob;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	public static final String data = "{\"client_ip\":\"10.23.2.101,172.23.20.183,\",\"protocol\":\"HTTP\",\"service_version\":\"v1\",\"method\":\"GET\"}";
	OkHttpClient client = new OkHttpClient();

	String run(String url, String json) throws Exception {
		RequestBody body = RequestBody.create(json, JSON);
		Request request = new Request.Builder().url(url).method("GET",null)
				//.addHeader("Authorization", "Basic ZWxhc3RpYzo5SHBWTldBRmpvS29XUlFlek94Wg==")
				.addHeader("Content-Type", "application/json")
				.addHeader("x-tenant-name", "incedo").build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public static void main(String[] args) {

		Main main = new Main();
		try {
			ExecutorService executorService = Executors.newFixedThreadPool(9);
			while(true) {
				Future<String> tt = executorService
						.submit(() -> main.run("http://localhost:30015/api/users?page=0&size=10", data));
				System.out.println(tt.get());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
