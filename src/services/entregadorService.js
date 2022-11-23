import http from "./banco";

export const listarEntregador = async () => {
  return http({
    method: "get",
    url: "/entregador/lista",
  }).then((response) => {
    return response.data;
  });
};
