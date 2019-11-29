	.globl	Main_main
Main_main:
	pushl	%ebp
	movl	%esp,%ebp
	subl	$16,%esp
	movl	$1,%eax
	movl	%eax,-4(%ebp)
	movl	$1,%eax
	movl	%eax,-8(%ebp)
	movl	-4(%ebp),%eax
	orl	%eax,%eax
	jz	l0
	movl	$1,%eax
	movl	-8(%ebp),%ebx
	cmpl	%eax,%ebx
	jl	l2
	movl	$2,%eax
	movl	%eax,-12(%ebp)
	movl	-8(%ebp),%eax
	movl	-12(%ebp),%ebx
	cmpl	%eax,%ebx
	jnz	l4
	movl	-4(%ebp),%eax
	movl	%eax,-16(%ebp)
	jmp	l5
l4:
	movl	-8(%ebp),%eax
	movl	-12(%ebp),%ebx
	cmpl	%eax,%ebx
	jnl	l6
	movl	$0,%eax
	movl	%eax,-16(%ebp)
	jmp	l7
l6:
	movl	$1,%eax
	movl	%eax,-16(%ebp)
l7:
l5:
	movl	$1,%eax
	movl	-12(%ebp),%ebx
	addl	%ebx,%eax
	pushl	%eax
	call	print
	addl	$4,%esp
	jmp	l3
l2:
	movl	$4,%eax
	movl	%eax,-12(%ebp)
	movl	-8(%ebp),%eax
	movl	-12(%ebp),%ebx
	cmpl	%eax,%ebx
	jnz	l8
	movl	-4(%ebp),%eax
	movl	%eax,-16(%ebp)
	jmp	l9
l8:
	movl	-8(%ebp),%eax
	movl	-12(%ebp),%ebx
	cmpl	%eax,%ebx
	jnl	l10
	movl	$0,%eax
	movl	%eax,-16(%ebp)
	jmp	l11
l10:
	movl	$1,%eax
	movl	%eax,-16(%ebp)
l11:
l9:
	movl	$1,%eax
	movl	-12(%ebp),%ebx
	addl	%ebx,%eax
	pushl	%eax
	call	print
	addl	$4,%esp
l3:
	jmp	l1
l0:
l1:
	movl	%ebp,%esp
	popl	%ebp
	ret
