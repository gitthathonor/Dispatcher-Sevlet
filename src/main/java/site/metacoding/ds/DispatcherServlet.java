package site.metacoding.ds;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doProcess() 호출");
//		String httpMethod = request.getMethod();
//		System.out.println(httpMethod);
		String identifier = request.getRequestURI();
		System.out.println(identifier);

		// 공통 로직 처리

		UserController c = new UserController();

		Method[] methodList = c.getClass().getDeclaredMethods();
		for (Method method : methodList) {
			// System.out.println(method.getName());
			Annotation annotation = method.getDeclaredAnnotation(RequestMapping.class);
			RequestMapping requestMapping = (RequestMapping) annotation;
			try {
				// System.out.println(requestMapping.value());
				if (identifier.equals(requestMapping.value())) {
					method.invoke(c);
				}
			} catch (Exception e) {
				System.out.println(method.getName() + "은 어노테이션이 없습니다.");
			}

		}

	}

}
