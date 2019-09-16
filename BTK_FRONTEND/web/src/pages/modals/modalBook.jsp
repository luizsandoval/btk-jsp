<div class="modal fade" id="modalBook" tabindex="-1" role="dialog" aria-labelledby="modalBook" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header align-items-center">
                <h4 class="modal-title" id="exampleModalLabel">Manter Livro</h4>
                <span class="text-muted modal-subtitle">Adicionar</span>
            </div>
            <div class="modal-body">
                <form>
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <div class="form-group">
                                <label for="bookName">Nome do Livro</label>
                                <input class="form-control" type="text" autofocus placeholder="Digite o nome do livro..."/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                            <div class="form-group">
                                <label for="bookGender">Gênero</label>
                                <select name="bookGender" class="form-control">
                                    <option value="">Selecione um gênero...</option>
                                    <option>Aventura</option>
                                    <option>Infanto Juvenil</option>
                                    <option>Romance</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                            <div class="form-group">
                                <label for="bookAuthor">Autor</label>
                                <select name="bookAuthor" class="form-control">
                                    <option value="">Selecione um autor...</option>
                                    <option>JK Rownling</option>
                                    <option>Rick Riordan</option>
                                    <option>Suzanne Collins</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                            <div class="form-group">
                                <label for="bookEditora">Editora</label>
                                <input name="bookEditora" class="form-control" type="text" placeholder="Digite o nome da Editora..."/>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                            <div class="form-group">
                                <label for="bookQuantity">Quantidade</label>
                                <input name="bookQuantity" class="form-control" type="number" placeholder="Digite a quantidade de exemplares..."/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-link" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary btn-md">Salvar Livro</button>
            </div>
        </div>
    </div>
</div>