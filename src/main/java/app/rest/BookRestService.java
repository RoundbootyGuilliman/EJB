package app.rest;

import app.dao.NewsDAO;
import app.entity.News;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/news")
@Stateless
public class BookRestService {
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Inject
	NewsDAO newsDAO;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllNews() throws JsonProcessingException {
		
		List<News> news = newsDAO.getAllNews();
		System.out.println(news.getClass());
		
		String json = mapper.writeValueAsString(news);
		
		return json;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getNewsById(@PathParam("id") int id) throws JsonProcessingException {
		News news = newsDAO.getNewsById(id);
		
		String json = mapper.writeValueAsString(news);
		
		return json;
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setNews(String json) throws IOException, URISyntaxException {
		News news = mapper.readValue(json, News.class);
		newsDAO.saveNews(news);
		return Response.created(new URI("news/" + news.getId())).build();
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editNews(String json) throws IOException {
		News news = mapper.readValue(json, News.class);
		newsDAO.saveNews(news);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response deleteNews(@PathParam("id") int id) {
		newsDAO.deleteNews(id);
		return Response.ok().build();
	}
}
