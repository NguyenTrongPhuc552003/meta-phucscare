SUMMARY = "Hello world recipe"
DESCRIPTION = "This is a simple Hello World recipe - uses a local source file"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://helloworld.c"

S = "${WORKDIR}"

RPROVIDES:${PN} = "helloworld-bin"
RDEPENDS:${PN} = "bash"

do_compile() {
	${CC} ${LDFLAGS} helloworld.c -o helloworld
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 helloworld ${D}${bindir}
}
