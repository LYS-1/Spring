<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <h3>Comment</h3>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Writer</th>
                    <th>Contents</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${result}" var="dto" varStatus="i">
                    <tr>
                        <td>
                            ${dto.writer}
                        </td>
                        <td id="table-contents-${dto.num}">
                            ${dto.contents}
                        </td>
                        <td>
                 	    	<c:if test="${member.id eq dto.writer}">
                           		<c:if test="${dto.contents ne '삭제된 댓글입니다.'}">
	                           		<button class="btn btn-primary updateComment" id="UpdateComment-${dto.num}" data-btn-idx="${dto.num}">수정하기</button>
								    <button class="btn btn-danger deleteComment" id="deleteComment" data-btn-idx="${dto.num}">삭제하기</button>
                                </c:if>
							</c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="row">
            <nav aria-label="Page navigation example">
                <div class="row">
                    <div class="col-md-10">
                        <ul class="pagination">
                            <c:if test="${pager.page != 1}">
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Previous" data-board-page="1">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${pager.page != 1 && pager.startNum-1 > 0}">
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Previous"
                                        data-board-page="${pager.startNum-1}">
                                        <span aria-hidden="true">&lsaquo;</span>
                                    </a>
                                </li>
                            </c:if>
    
                            <c:forEach begin="${pager.startNum}" end="${pager.endNum}" var="i">
                                <li class="page-item"><a class="page-link" href="#" data-board-page="${i}">${i}</a>
                                </li>
                            </c:forEach>
    
                            <c:if test="${pager.page != pager.totalPage && pager.endNum + 1 <= pager.totalPage}">
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next" data-board-page="${pager.endNum + 1}">
                                        <span aria-hidden="true">&rsaquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${pager.after == false }">
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next" data-board-page="${pager.totalPage}">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                    <div class="col-md-2">
                        <p class="fw-bold">${pager.page}/${pager.totalPage} 페이지</p>
                    </div>
                </div>
            </nav>
        </div>
    </div>